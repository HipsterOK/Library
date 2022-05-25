<template>
  <form @submit.prevent class="form">

    <input v-model="localBook.title" type="text" placeholder="Название книги"/>
    <textarea v-model="localBook.description" type="text" placeholder="Описание книги"/>
    <input v-model="localBook.link" type="text" placeholder="Ссылка книги"/>

    <!--        <select v-model="copyBook.type">&ndash;&gt;-->
    <!--          <option value="AUDIO_BOOK">Аудио книга</option>-->
    <!--          <option value="PHYSICAL_BOOK">Бумажная книга</option>-->
    <!--          <option value="VIDEO_BOOK">Видеоматериалы</option>-->
    <!--        </select>-->
    <div class="flex justify-start ml-2 mt-2">
      <input list="genres" name="myGenre" type="text" placeholder="Жанр" @focusout="saveGenre"
             v-model="localGenre.name"/>
      <datalist id="genres">
        <option v-for="genre in genres" :key="genre">{{ genre.name }}</option>
      </datalist>
      <button class="btn btn-success" @click="saveGenre">Сохранить жанр</button>
    </div>
    <div v-for="(author, index) in authorLines" :key="index">
      <div class="flex justify-start ml-2 mt-2">
        <select
                v-model="authorLines[index].author">
          <option
              v-for="author in authors"
              v-bind:key="author.id"
              v-bind:value="author"
              v-text="author.surname + ' ' + author.name + ' ' + author.patronymic"
          ></option>
        </select>
        <button type="button"
          class="ml-2 rounded-md border px-2 py-1 bg-white text-black"
          @click="addMore()"
          v-show="index == 0">
          +
        </button>
        <button
            type="button"
            class="ml-2 rounded-md border px-2 py-1 bg-white text-black"
            @click="removeAuthorLine(index)"
            v-show="index != 0">
          -
        </button>
      </div>
    </div>
    <button class="btn btn-success" @click="createAuthor">Создать автора</button>

    <div class="flex justify-start ml-2 mt-2">
      <button class="btn btn-success" @click="savePaperBook">Сохранить книгу</button>
      <button class="btn btn-danger" @click="closeForm">Отменить</button>
    </div>
    <div class="flex justify-start ml-2 mt-2">
      <button disabled class="btn btn-success" @click="saveAuthorships">Сохранить авторство</button>

    </div>
    <div v-if="dialogVisible">
      <author-form/>
    </div>

  </form>
</template>

<script>
import AuthorForm from "@/components/books/AuthorForm";

export default {
  name: "PaperBookView",
  mounted() {
    this.$store.dispatch("getAuthors")
    this.$store.dispatch("getGenres")
    this.localBook = this.paperBook
    this.localGenre = this.paperBook.genre
    this.saveGenre();
  },
  data() {
    return {
      localBook: {},
      authorLines: [{}],
      authorships: [{}],
      localGenre: {},
      localAuthorship: {},
    }
  },
  components: {
    AuthorForm,
  },
  computed: {
    dialogVisible() {
      return this.$store.state.showAuthorForm
    },
    paperBook() {
      return this.$store.state.paperBookToEdit;
    },
    genres() {
      return this.$store.state.genres;
    },
    genre() {
      return this.$store.state.genreToAdd;
    },
    authors() {
      return this.$store.state.authors;
    }
  },
  methods: {
    saveAuthorships() {
      for (var a=0;a < this.authorLines.length; a++){
        this.saveAuthorship(this.authorLines[a].author)
      }
    },
    saveAuthorship(author) {
      console.log("saveAuthorship: " + this.paperBook.id)
      console.log("saveAuthorship: " + author.id)
      this.localAuthorship.paperBook = this.paperBook;
      this.localAuthorship.author = author;
      console.log( this.localAuthorship)
      this.$store.dispatch("createAuthorship", this.localAuthorship);
    },
    createAuthor() {
      this.$store.dispatch("switchAuthorForm", true);
      this.$store.dispatch("setAuthor", {})
    },
    savePaperBook() {
      this.localBook.genre = this.genre
      this.$store.dispatch("createPaperBook", this.localBook)
    },
    saveButton() {
      this.savePaperBook();
      // this.saveAuthorships();
      this.dialogVisibleToggle = this.dialogVisible;
      this.$router.push('book')
    },
    saveGenre() {
      // if (!this.genres.some(e => e.name === this.genre.name))
      if (this.localGenre.name != undefined) {
        {
          this.$store.dispatch("createGenre", this.localGenre)
        }
      }
    },
    addMore() {
      if (this.authorLines.length <= 4) {
        this.authorLines.push({});
      }
    },
    removeAuthorLine(index) {
      this.authorLines.splice(index, 1);
    },
    closeForm() {
      this.$store.dispatch("switchPaperBookForm", false)
    },
  }

}
</script>

<style scoped>
.form-bg {
  background: rgba(0, 0, 0, 0.5);
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
}

.form {
  background: #F9FBE7;
  width: 600px;
  height: 650px;
  border-radius: 20px;
  border: solid black;
  display: flex;
  flex-direction: column;
  font-size: 20px;
  margin: auto;
  align-items: center;
  align-content: center;
  padding-top: 30px;
  position: absolute;
}
</style>