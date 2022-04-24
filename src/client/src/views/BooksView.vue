<template>
  <button @click="createBook">Добавить книгу</button>
  <book-list :books="books" />
  <div v-if="dialogVisible">
    <book-form  @closeForm="closeForm" />
  </div>
</template>

<script>
import BookList from "@/components/books/BookList.vue";
import BookForm from "@/components/books/BookForm.vue";

export default {
  data() {
    return {
      formSwitch: false,
    };
  },
  components: {
    BookList,
    BookForm,
  },
  computed: {
    books() {
      return this.$store.state.books
    },
    dialogVisible() {
      return this.$store.state.showForm
    },
  },
  methods: {
    createBook() {
      this.$store.dispatch("switchForm", true);
      this.$store.dispatch("setBook", {})
    },
    closeForm() {
      this.dialogVisibility();
    },
    dialogVisibility() {
      this.dialogVisibleToggle = !this.dialogVisible;
    },
    editBook(book) {
      console.log(book.id + " for edit from parent");
      this.dialogVisibleToggle = this.dialogVisible;
    },
  },
  mounted() {
    this.$store.dispatch("getBooks");
  },
};
</script>
