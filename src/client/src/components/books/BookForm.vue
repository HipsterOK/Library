<template>
    <div class="form-bg">
        <form @submit.prevent class="form">
            <input v-model="book.title" type="text" placeholder="Название книги"/>
          <textarea v-model="book.description" type="text" placeholder="Описание книги" />
            <input v-model="book.quantity" type="number" placeholder="Количество"/>
            <!--      <input v-model="book.type" type="text" placeholder="Тип книги" />-->
            <select v-model="book.type">
                <option value="AUDIO_BOOK">Аудио книга</option>
                <option value="PHYSICAL_BOOK">Бумажная книга</option>
                <option value="VIDEO_BOOK">Видеоматериалы</option>
            </select>
            <!--      <input v-model=" book.genre.name" type="text" placeholder="Жанр" />-->
            <select v-model="book.genre">
                <option v-for="genre in genres" :value="genre" :key="genre">
                    {{ genre.name }}
                </option>
            </select>
<!--            <input v-model=" book.addDate" type="text" placeholder="Дата добавления:"/>-->
            <!--      <input v-model="  book.libId.name " type="text" placeholder="Библиотека:" />-->
            <select v-model="book.libId">
                <option v-for="lib in libs" :value="lib" :key="lib"> {{ lib.name }} </option>
            </select>
            <input v-model="  book.src " type="text" placeholder="Ссылка:"/>
          <div v-for="(author, index) in authorLines" :key="index">
            <div class="flex justify-start ml-2 mt-2">
              <select v-model="selected">
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
          <div class="flex justify-start ml-2 mt-2">
            <button class="btn btn-success"  @click="saveBook" > Сохранить</button>
            <button class="btn btn-danger" @click="closeForm"> Отменить </button>
          </div>
        </form>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
      mounted() {
        this.getAuthors()
        this.getAuthorshipByBookId(105)
      },
      data(){
        return {
          authors: [{}
            // {
            //   id: 1,
            //   surname: "asd"
            // },
            // {
            //   id: 2,
            //   surname: "bsd"
          ],
          authorLines: [{
          }],
          authorships: [{}],
        }
      },
        computed: {
            book() {
                return this.$store.state.bookToEdit;
            },
            genres() {
                return this.$store.state.genres;
            },
            libs() {
                return this.$store.state.libs;
            }
        },
        methods: {
          getAuthors() {
            axios.get(`http://localhost:8080/author/`).then(response => {
              this.authors = response.data
              console.log(this.authors)
            })
          },
          getAuthorshipByBookId(bookID) {
            axios.get(`http://localhost:8080/authorship?bookId=${bookID}`).then(response => {
              this.authorships = response.data
              console.log(this.authorships)
            })
          },
            closeForm() {
                this.$store.dispatch("switchForm", false)
            },
            saveBook() {
                this.$store.dispatch("createBook", this.book)
                this.$store.dispatch("switchForm", false)
            },
          addMore() {
            if (this.authorLines.length <= 4)
            this.authorLines.push({
            });
          },
          removeAuthorLine(index) {
            this.authorLines.splice(index, 1);
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
        height: 700px;
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