<template>
  <form @submit.prevent class="form">

    <input v-model="localBook.title" type="text" placeholder="Название книги"/>
    <textarea v-model="localBook.description" type="text" placeholder="Описание книги"/>
<!--    <select v-model="paperBook.genre">-->
<!--      <option v-for="optGenre in genres"-->
<!--              v-bind:value="optGenre" :key="optGenre" :text="optGenre.name"></option>-->
<!--    </select>-->
    <input v-model="localBook.link" type="text" placeholder="Ссылка книги"/>

<!--        <select v-model="copyBook.type">&ndash;&gt;-->
<!--          <option value="AUDIO_BOOK">Аудио книга</option>-->
<!--          <option value="PHYSICAL_BOOK">Бумажная книга</option>-->
<!--          <option value="VIDEO_BOOK">Видеоматериалы</option>-->
<!--        </select>-->
    <div class="flex justify-start ml-2 mt-2">
      <input list="genres" name="myGenre" type="text" placeholder="Жанр" @focusout="saveGenre" v-model="localGenre.name"/>
      <datalist id="genres">
        <option v-for="genre in genres" :key="genre">{{ genre.name }}</option>
      </datalist>
      <button class="btn btn-success" @click="saveGenre">Сохранить жанр</button>
    </div>
<!--    <div v-for="(author, index) in authorLines" :key="index">-->
<!--      <div class="flex justify-start ml-2 mt-2">-->
<!--        <select v-model="authorz">-->
<!--          <option-->
<!--              v-for="author in authors"-->
<!--              v-bind:key="author.id"-->
<!--              v-bind:value="author"-->
<!--              v-text="author.surname + ' ' + author.name + ' ' + author.patronymic"-->
<!--          ></option>-->
<!--        </select>-->
<!--        <button type="button"-->
<!--                class="ml-2 rounded-md border px-2 py-1 bg-white text-black"-->
<!--                @click="addMore()"-->
<!--                v-show="index == 0">-->
<!--          +-->
<!--        </button>-->
<!--        <button-->
<!--            type="button"-->
<!--            class="ml-2 rounded-md border px-2 py-1 bg-white text-black"-->
<!--            @click="removeAuthorLine(index)"-->
<!--            v-show="index != 0">-->
<!--          - -->
<!--        </button>-->
<!--      </div>-->
<!--    </div>-->
    <div class="flex justify-start ml-2 mt-2">
      <button class="btn btn-success" @click="savePaperBook">Сохранить</button>
    </div>
  </form>
</template>

<script>
import axios from "axios";

export default {
  name: "PaperBookView",
  mounted() {
    this.$store.dispatch("getGenres")
    this.getAuthors()
    this.getAuthorshipByBookId(105)
    this.localBook = this.paperBook
    this.localGenre.name = this.paperBook.genre.name
  },
  data() {
    return {
      authors: [{}],
      localBook: {},
      authorLines: [{}],
      authorships: [{}],
      localGenre: {}
  }
  },
  computed: {
    paperBook() {
      return this.$store.state.paperBookToEdit;
    },
    genres() {
      return this.$store.state.genres;
    },
    genre() {
      return this.$store.state.genreToAdd;
    },
  },
  methods: {
    savePaperBook() {
      // if (!this.genres.some(e => e.name === this.genre.name))
      //this.$store.dispatch("createGenre", this.genre)
      this.localBook.genre = this.genre
      this.$store.dispatch("createPaperBook", this.localBook)
      this.$router.push('book')
    },
    saveGenre() {
      // if (!this.genres.some(e => e.name === this.genre.name))
      this.$store.dispatch("createGenre", this.localGenre)
      console.log("paperBook genre" + this.paperBook.genre)
    },
    getAuthors() {
      axios.get(`http://localhost:8080/author/`).then(response => {
        this.authors = response.data
        // console.log(this.authors)
      })
    },
    getAuthorshipByBookId(bookID) {
      axios.get(`http://localhost:8080/authorship?bookId=${bookID}`).then(response => {
        this.authorships = response.data
        // console.log(this.authorships)
      })
    },
    addMore() {
      if (this.authorLines.length <= 4)
        this.authorLines.push({});
    },
    removeAuthorLine(index) {
      this.authorLines.splice(index, 1);
    },
  }

}
</script>

<style scoped>

</style>