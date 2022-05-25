<template>
  <div class="form-bg">
    <form @submit.prevent class="form">
      <input v-model="author.surname" type="text" placeholder="Фамилия"/>
      <input v-model="author.name" type="text" placeholder="Имя"/>
      <input v-model="author.patronymic" type="text" placeholder="Отчество"/>
      <div class="flex justify-start ml-2 mt-2">
        <button class="btn btn-success" @click="saveBookButton">Подтвердить</button>
        <button class="btn btn-danger" @click="closeForm"> Отменить</button>
      </div>
    </form>
  </div>
</template>

<script>

export default {
  // mounted() {
  //
  // },
  // data() {
  //
  // },
  computed: {
    author() {
      console.log(this.$store.state.authorToEdit)
      return this.$store.state.authorToEdit;
    },
  },
  methods: {
    closeForm() {
      this.$store.dispatch("switchAuthorForm", false)
    },
    saveBookButton() {
      this.$store.dispatch("createAuthor", this.author)
      this.$store.dispatch("setAuthors", this.author)
      this.$store.dispatch("switchAuthorForm", false)
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
  width: 600px;
  height: 300px;
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
  top: 40%;
  left: 40%;
}
</style>