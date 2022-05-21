<template>
  <div class="form-bg">
    <form @submit.prevent class="form">
      <!--          <input @input="onInput"  list="datalist_bookNames" type="text" placeholder="Название книги" id="input"/>-->
      <!--      <input type="radio" v-model="flag" :value="true" @click="oldBookLogic"/><label>Существующая книга</label>-->
      <!--      <input type="radio" v-model="flag" :value="false" @click="newBookLogic"/><label>Новая книга</label>-->
      <select v-model="copyBook.paperBook" id="select_paperBook" placeholder="Название книги" @change="selectChange(copyBook.paperBook)">
        <option v-for="singlePaperBook in paperBooks"
                v-bind:value="singlePaperBook" :key="singlePaperBook"
                >{{singlePaperBook.title}}</option>
      </select>
      <div class="flex justify-start ml-2 mt-2">
        <button v-if="copyBook.paperBook!=undefined" class="btn btn-success" @click="createNewBook(copyBook.paperBook)">Изменить книгу</button>
        <button class="btn btn-success" @click="createNewBook({genre:{}})">Нет книги?</button>
      </div>


            <input disabled v-if="copyBook.paperBook!=undefined" v-model="copyBook.paperBook.title" type="text" placeholder="Название книги"/>
            <textarea disabled  v-if="copyBook.paperBook!=undefined"
                      v-model="copyBook.paperBook.description" type="text" placeholder="Описание книги"/>
            <input disabled v-if="copyBook.paperBook!=undefined" v-model="copyBook.paperBook.genre" placeholder="Количество"/>
            <input disabled  v-if="copyBook.paperBook!=undefined" v-model="copyBook.paperBook.link" type="text" placeholder="Ссылка книги"/>


      <!--      <div class="flex justify-start ml-2 mt-2">-->
      <!--        <button class="btn btn-success" @click="savePaperBook(this.chosenPaperBook)">Сохранить</button>-->
      <!--      </div>-->

      <input v-model="copyBook.quantity" type="number" placeholder="Количество"/>


      <select v-model="copyBook.lib">
        <option v-for="lib in libs" v-bind:value="lib" :key="lib"> {{ lib.name }}</option>
      </select>

      <div class="flex justify-start ml-2 mt-2">
        <button class="btn btn-success" @click="saveBookButton(copyBook)"> Сохранить</button>
        <button class="btn btn-danger" @click="closeForm"> Отменить</button>
      </div>
      <div v-if="dialogVisible">
        <book-acceptance-form @closeForm="closeAcceptanceForm" />
      </div>
    </form>
  </div>
</template>

<script>
import BookAcceptanceForm from "@/components/books/BookAcceptanceForm";
export default {
  mounted() {
    this.$store.dispatch("getPaperBooks");
  },
  data() {
    return {
      formSwitch: false,
      flag: false
    }
  },
  components: {
    BookAcceptanceForm,
  },
  computed: {
    copyBook() {
      console.log(this.$store.state.bookToEdit)
      return this.$store.state.bookToEdit;
    },
    dialogVisible() {
      return this.$store.state.showBookAcceptanceForm
    },
    genres() {
      return this.$store.state.genres;
    },
    libs() {
      return this.$store.state.libs;
    },
    genre() {
      return this.$store.state.genreToAdd;
    },
    paperBooks() {
      return this.$store.state.paperBooks;
    },
    paperBook() {
      return this.$store.state.paperBookToEdit;
    },
  },
  methods: {
    selectChange(value) {
      console.log(value)
      this.flag = true
    },
    closeAcceptanceForm() {
      this.dialogVisibility();
    },
    dialogVisibility() {
      this.dialogVisibleToggle = !this.dialogVisible;
    },
    createNewBook(paperBook) {
      this.$store.dispatch('setPaperBook', paperBook)
      this.$router.push('paperBook')
    },
    saveGenre() {
      this.$store.dispatch("createGenre", this.genre)
    },
    closeForm() {
      this.$store.dispatch("switchForm", false)
    },
    saveBook() {
      // if (this.copyBook.code == null || this.copyBook.code == "") {
      //   this.$store.dispatch("createBook", this.copyBook)
      // }
      this.dialogVisibleToggle = this.dialogVisible;
      this.$store.dispatch("switchBookAcceptanceForm", true)
      //this.$store.dispatch("switchForm", false)
      //this.$store.dispatch("createBook", this.copyBook)

    },
    saveBookButton() {
      this.saveBook()
    },
  },

}
</script>

<style>
.form-bg {
  background: rgba(0, 0, 0, 0.5);
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
}

.form {
  background: #F9FBE7;
  width: 500px;
  height: 450px;
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
  top: 20%;
  left: 40%;
}
</style>