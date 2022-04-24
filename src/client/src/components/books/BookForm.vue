<template>
  <div class="form-bg">
    <form @submit.prevent class="form">
      <input v-model="book.title" type="text" placeholder="Название книги" />
      <input v-model="book.quantity" type="number" placeholder="Количество" />
      <input v-model="book.type" type="text" placeholder="Тип книги" />

      <button @click="saveBook"> Сохранить </button>
      <button @click="closeForm"> X </button>
    </form>
  </div>
</template>

<script>
export default {
  computed: {
    book() {
      return this.$store.state.bookToEdit;
    }
  },
  methods: {
    closeForm() {
      this.$store.dispatch("switchForm", false)
    },
    saveBook() {
      this.$store.dispatch("createBook", this.book)
      this.$store.dispatch("switchForm", false)
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
  width: 400px;
  height: 230px;
  border-radius: 20px;
  display: flex;
  flex-direction: column;
  font-size: 20px;
  margin: auto;
  align-items: center;
  align-content: center;
  padding-top: 30px;
  position: absolute;
  top: 40%;
  left: 40%;
}
</style>