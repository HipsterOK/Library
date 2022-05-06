import axios from "axios";
import { createStore } from "vuex";

var url = 'http://localhost:8081/bookCopy'

export default createStore({
    state: {
        books: [],
        copyBook: {},
        bookToOpen : {},
        bookToEdit: {},
        showForm: false,
        genres: [],
        libs: [],
        genreToAdd: {},
        paperBooks: [],
        paperBookToAdd: {}
    },
    mutations: {
        SET_BOOKS(state, books) {
            state.books = books
        },
        SET_PAPER_BOOKS(state, paperBooks) {
            state.paperBooks = paperBooks
        },
        CREATE_BOOK(state, book) {
            console.log('state: ' + book)
            state.books.push(book)
            //axios.post(`/book`, this.book).then(r => console.log(r.statusText+'данные сохранены'))
        },
        CREATE_GENRE(state, genre) {
            console.log('state: ' + genre)
            state.genres.push(genre)
            //axios.post(`/book`, this.book).then(r => console.log(r.statusText+'данные сохранены'))
        },
        // DELETE_BOOK(state, id) {
        //     let index = state.books.findIndex(book => book.id == id);
        //     state.books.splice(index, 1)
        // },
        SET_BOOK_TO_EDIT(state, bookToEdit) {
            state.bookToEdit = bookToEdit
        },
        SWITCH_FORM(state, Boolean) {
            state.showForm = Boolean
        },
        SET_BOOK_TO_OPEN(state, book) {
            state.bookToOpen = book
        },
        SET_GENRES(state, genres){
            state.genres = genres
        },
        SET_LIBS(state, libs){
            state.libs = libs
        }
    },
    actions: {
        getBooks({ commit }, title = "") {
            axios.get(url, { params: { title: title.title, libId: title.libId } })
                .then(response => {
                    var books = response.data.sort((a, b) => a.id - b.id)
                    commit('SET_BOOKS', books)
                })
        },
        createBook({ commit }, book) {
            axios.post(url, book)
                .then(response => {
                    if (response.status == '200') {
                        console.log(response.data)
                        console.log(response.status)
                        commit('CREATE_BOOK', response.data)
                    }
                })
                .catch(error => {
                    console.log(error)
                })
        },
        createGenre({commit}, genre) {
            axios.post('http://localhost:8081/genre', genre)
                .then(response => {
                    if (response.status == '200') {
                        console.log(response.data)
                        console.log(response.status)
                        commit('CREATE_GENRE', response.data)
                    }
                })
                .catch(error => {
                    console.log(error)
                })
        },
        // deleteBook({ commit }, id) {
        //     try {
        //         axios.delete(url + id)
        //             .then(() => {
        //                 commit('DELETE_BOOK', id)
        //             });
        //     } catch (error) {
        //         console.log(error)
        //     }
        // },
        setBook({ commit }, bookToEdit) {
            if (bookToEdit.id > 0) {
                console.log('id bolshe 0')
            }
            commit('SET_BOOK_TO_EDIT', bookToEdit)
        },
        switchForm({ commit }, Boolean) {
            commit('SWITCH_FORM', Boolean)
        },
        setBookToOpen({commit}, book) {
            commit('SET_BOOK_TO_OPEN', book)
        },
        getGenres({ commit }) {
            axios.get('/genre')
                .then(response => {
                    var genres = response.data.sort((a, b) => a.id - b.id)
                    commit('SET_GENRES', genres)
                })
        },
        getPaperBooks({ commit }) {
            axios.get('/paperBook')
                .then(response => {
                    var paperBooks = response.data.sort((a, b) => a.id - b.id)
                    console.log(paperBooks)
                    commit('SET_PAPER_BOOKS', paperBooks)
                })
        },
        getLibs({ commit }) {
            axios.get('/libraryOffice')
                .then(response => {
                    var libs = response.data.sort((a, b) => a.id - b.id)
                    commit('SET_LIBS', libs)
                })
        },
    },
    getters: {
        getBook: state => state.bookToOpen
    }
})