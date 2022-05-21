<template>
  <div class="form-bg">
    <form @submit.prevent class="form">
      <input v-if="copyBook.code==undefined" disabled type="text" placeholder="Книга еще не существует"/>
      <input v-if="copyBook.code!=undefined" disabled v-model="copyBook.code" type="text" placeholder="Код"/>
      <div class="flex justify-start ml-2 mt-2">
        <button class="btn btn-success" @click="saveBookButton()">Подтвердить</button>
<!--        <button v-if="copyBook.code==undefined" class="btn btn-success" @click="createBookButton()">Создать книгу</button>-->
        <button class="btn btn-danger" @click="closeForm()"> Отменить</button>
      </div>
    </form>
  </div>
</template>

<script>

export default {
  mounted() {

  },
  data() {

  },
  computed: {
    copyBook() {
      console.log(this.$store.state.bookToEdit)
      return this.$store.state.bookToEdit;
    },
  },
  methods: {
    closeForm() {
      this.$store.dispatch("switchBookAcceptanceForm", false)
    },
    saveBookButton() {
      if (this.copyBook.code =="" || this.copyBook.code==null) {
        this.$store.dispatch("createBook", this.copyBook)
      }
      else {
        this.$store.dispatch("switchBookAcceptanceForm", false)
        this.$store.dispatch("switchForm", false)
        this.$store.dispatch("createBook", this.copyBook)
      }
    },
    createBookButton(){
      this.$store.dispatch("createBook", this.copyBook)
    }
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