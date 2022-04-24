<template>
  <div>
    <book-item class="book" v-for="book in books" :book="book" :key="book.id" />
  </div>
</template>

<script>
import BookItem from "@/components/books/BookItem.vue";
export default {
  components: {
    BookItem,
  },
  props: {
    books: Array,
  },
};
</script>

