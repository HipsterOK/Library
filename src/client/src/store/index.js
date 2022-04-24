import axios from "axios";
import { createStore } from "vuex";

var url = 'http://localhost:8081/book/'

export default createStore({
    state: {
        books: [],
        book: {},
        bookToOpen : {},
        bookToEdit: {},
        showForm: false
    },
    mutations: {
        SET_BOOKS(state, books) {
            state.books = books
        },
        CREATE_BOOK(state, book) {
            console.log('state: ' + book)
            state.books.push(book)
        },
        DELETE_BOOK(state, id) {
            let index = state.books.findIndex(book => book.id == id);
            state.books.splice(index, 1)
        },
        SET_BOOK_TO_EDIT(state, bookToEdit) {
            state.bookToEdit = bookToEdit
        },
        SWITCH_FORM(state, Boolean) {
            state.showForm = Boolean
        },
        SET_BOOK_TO_OPEN(state, book) {
            state.bookToOpen = book
        }
    },
    actions: {
        getBooks({ commit }) {
            axios.get(url)
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
        deleteBook({ commit }, id) {
            try {
                axios.delete(url + id)
                    .then(() => {
                        commit('DELETE_BOOK', id)
                    });
            } catch (error) {
                console.log(error)
            }
        },
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
        }
    },
    getters: {
        getBook: state => state.bookToOpen
    }
})