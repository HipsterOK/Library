import axios from "axios";
import {createStore} from "vuex";

var url = 'http://localhost:8081/bookCopy'

export default createStore({
    state: {
        books: [],
        copyBook: {},
        bookToOpen: {},
        bookToEdit: {},
        showForm: false,
        genres: [],
        libs: [],
        genreToAdd: {},
        paperBooks: [],
        paperBookToAdd: {},
        paperBookToEdit: {},
        showBookAcceptanceForm: false,
        authorToEdit: {}

    },
    mutations: {
        SET_BOOKS(state, books) {
            state.books = books
        },
        SET_PAPER_BOOKS(state, paperBooks) {
            //state.paperBookToEdit = paperBooks[0]
            //console.log(state.paperBookToEdit)
            state.paperBooks = paperBooks
        },
        CREATE_BOOK(state, book) {
            // console.log('state: ' + book)
            state.bookToEdit = book
            console.log('createBook' + book)
            state.books.push(book)
            //axios.post(`/book`, this.book).then(r => console.log(r.statusText+'данные сохранены'))
        },
        CREATE_GENRE(state, genre) {
            console.log('state: ' + genre)
            state.genreToAdd = genre
            state.genres.push(genre)
            //axios.post(`/book`, this.book).then(r => console.log(r.statusText+'данные сохранены'))
        },
        CREATE_PAPER_BOOK(state, paperBook) {
            console.log('paper book state: ' + paperBook.id)
            state.paperBookToEdit = paperBook
            state.paperBooks.push(paperBook)
            state.paperBookToAdd = paperBook
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
        SET_GENRES(state, genres) {
            state.genres = genres
        },
        SET_LIBS(state, libs) {
            state.libs = libs
        },
        SET_PAPER_BOOK_TO_EDIT(state, paperBook) {
            state.paperBookToEdit = paperBook
        },
        SWITCH_BOOK_ACCEPTANCE_FORM(state, Boolean) {
            state.showBookAcceptanceForm = Boolean
        },
        SET_AUTHOR(state, author) {
            state.authorToEdit = author
        }
    },
    actions: {
        getBooks({commit}, title = "") {
            axios.get(url, {params: {title: title.title, libId: title.libId}})
                .then(response => {
                    var books = response.data.sort((a, b) => a.id - b.id)
                    commit('SET_BOOKS', books)
                })
        },
        createBook({commit}, book) {
            axios.post(url, book)
                .then(response => {
                    if (response.status == '200') {
                        console.log(book.quantity)
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
        createPaperBook({commit}, paperBook) {
            axios.post('http://localhost:8081/paperBook', paperBook)
                .then(response => {
                    if (response.status == '200') {
                        console.log(response.data)
                        console.log(response.status)
                        commit('CREATE_PAPER_BOOK', response.data)
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
        setBook({commit}, bookToEdit) {
            if (bookToEdit.id > 0) {
                console.log('id bolshe 0')
            }
            commit('SET_BOOK_TO_EDIT', bookToEdit)
        },
        setPaperBook({commit}, paperBookToEdit) {
            commit('SET_PAPER_BOOK_TO_EDIT', paperBookToEdit)
        },
        switchForm({commit}, Boolean) {
            commit('SWITCH_FORM', Boolean)
        },
        switchBookAcceptanceForm({commit}, Boolean) {
            commit('SWITCH_BOOK_ACCEPTANCE_FORM', Boolean)
        },
        setBookToOpen({commit}, book) {
            commit('SET_BOOK_TO_OPEN', book)
        },
        getGenres({commit}) {
            axios.get('/genre')
                .then(response => {
                    var genres = response.data.sort((a, b) => a.id - b.id)
                    commit('SET_GENRES', genres)
                })
        },
        getPaperBooks({commit}) {
            axios.get('/paperBook')
                .then(response => {
                    var paperBooks = response.data.sort(function(a, b){
                        if(a.title < b.title) { return -1; }
                        if(a.title > b.title) { return 1; }
                        return 0;
                    })
                    //  console.log(paperBooks)
                    commit('SET_PAPER_BOOKS', paperBooks)
                })
        },
        getLibs({commit}) {
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