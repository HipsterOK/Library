<template>
<!--  <button @click="createBook">Добавить книгу</button>-->
  <button @click="findBook(searchString,selected_game.id)">Найти книгу</button>
  <select v-model="selected_game">
    <option value="" selected disabled hidden>Choose here</option>
    <option v-for="lib in libs" :value="lib" :key="lib">{{lib.name}}</option>
  </select>
  <input v-model="searchString" placeholder="Название книги..." type="text"/>
  <book-list :books="books"/>
<!--  <div v-if="dialogVisible">-->
<!--    <book-form  @closeForm="closeForm" />-->
<!--  </div>-->
</template>

<script>
import BookList from "@/components/books/BookList.vue";
// import BookForm from "@/components/books/BookForm.vue";

export default {
  data() {
    return {
      formSwitch: false,
      selected_game: "",
      searchString: "",
    };
  },
  components: {
    BookList,
    // BookForm,
  },
  computed: {
    books() {
      return this.$store.state.books
    },
    // dialogVisible() {
    //   return this.$store.state.showForm
    // },
    libs() {
      return this.$store.state.libs
    },
  },
  mutations: {

  },
  methods: {
    // createBook() {
    //   this.$store.dispatch("switchForm", true);
    //   this.$store.dispatch("setBook", {})
    // },
    // closeForm() {
    //   this.dialogVisibility();
    // },
    // dialogVisibility() {
    //   this.dialogVisibleToggle = !this.dialogVisible;
    // },
    // editBook(book) {
    //   console.log(book.id + " for edit from parent");
    //   this.dialogVisibleToggle = this.dialogVisible;
    // },
    findBook(title = "", libId ="") {
      this.$store.dispatch("getBooks", {title:title, libId:libId});
    }
  },
  mounted() {
    this.$store.dispatch("getBooks");
    // this.$store.dispatch("getGenres")
    this.$store.dispatch("getLibs")
  },
};
</script>
