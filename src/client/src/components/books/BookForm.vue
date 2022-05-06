<template>
    <div class="form-bg">
        <form @submit.prevent class="form">
          <v-combobox v-for="paperBook in paperBooks" :value="paperBook" :key="paperBook"></v-combobox>
          <input @input="onInput" v-model="copyBook.title" list="datalist_bookNames" type="text" placeholder="Название книги" id="input"/>
          <datalist id="datalist_bookNames" >
            <option v-for="paperBook in paperBooks" :value="paperBook" :key="paperBook">{{paperBook.title}}</option>
          </datalist>

          <textarea v-model="paperBooksToAdd" type="text" v-text="paperBooksToAdd.description" placeholder="Описание книги" />
          <input v-model="copyBook.quantity" type="number" placeholder="Количество"/>

          <select v-model="copyBook.type">
            <option value="AUDIO_BOOK">Аудио книга</option>
            <option value="PHYSICAL_BOOK">Бумажная книга</option>
            <option value="VIDEO_BOOK">Видеоматериалы</option>
          </select>

          <input list="genres" name="myGenre" type="text" placeholder="Жанр" v-model="genre.name"/>
          <datalist id="genres">
            <option v-for="genre in genres" :key="genre">{{genre.name}}</option>
          </datalist>
          <button class="btn btn-success"  @click="saveGenre" >Сохранить</button>
            <select v-model="copyBook.libId">
                <option v-for="lib in libs" :value="lib" :key="lib"> {{ lib.name }} </option>
            </select>
          <input v-model="  copyBook.src " type="text" placeholder="Ссылка:"/>

          <div v-for="(author, index) in authorLines" :key="index">
            <div class="flex justify-start ml-2 mt-2">
              <select v-model="authorz">
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
        this.$store.dispatch("getPaperBooks");
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
          paperBookToAdd: {},
          chosenPaperBook: {}
        }
      },
        computed: {
            copyBook() {
                return this.$store.state.bookToEdit;
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
            paperBooksToAdd() {
              return this.$store.state.paperBookToAdd;
            }
        },
        methods: {
           onInput(e) {
             let val = e.target.value;
             if (val) {
               this.chosenPaperBook = val;
               console.log(this.chosenPaperBook);
             }
          },
          saveInstance(paperBook) {
            console.log(paperBook)
            this.chosenPaperBook = paperBook;
          },
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
          saveGenre() {
            // if (!this.genres.some(e => e.name === this.genre.name))
            this.$store.dispatch("createGenre", this.genre)
          },
            closeForm() {
                this.$store.dispatch("switchForm", false)
            },
            saveBook() {
                this.$store.dispatch("createBook", this.copyBook)
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