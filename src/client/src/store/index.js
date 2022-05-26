import axios from "axios";
import {createStore} from "vuex";

axios.defaults.baseURL = '/api'

export default createStore({
    state: {
        books: [],
        copyBook: {},
        bookToOpen: {},
        bookToEdit: {},
        showForm: false,
        showBookAcceptanceForm: false,
        showAuthorForm: false,
        showPaperBookForm: false,
        genres: [],
        libs: [],
        authors: [],
        genreToAdd: {},
        paperBooks: [],
        paperBookToEdit: {},
        authorToEdit: {},
        authorshipToEdit: {},
        allBooks: {},
        abstractBook:{}
    },
    mutations: {
        SET_BOOKS(state, books) {
            state.books = books
        },
        SET_PAPER_BOOKS(state, paperBooks) {
            state.paperBooks = paperBooks
        },
        CREATE_BOOK(state, book) {
            state.bookToEdit = book
            state.books.push(book)
            //axios.post(`/book`, this.book).then(r => console.log(r.statusText+'данные сохранены'))
        },
        CREATE_GENRE(state, genre) {
            state.genreToAdd = genre
            state.genres.push(genre)
            //axios.post(`/book`, this.book).then(r => console.log(r.statusText+'данные сохранены'))
        },
        CREATE_PAPER_BOOK(state, paperBook) {
            console.log(paperBook)
            state.paperBookToEdit = paperBook
            state.paperBooks.push(paperBook)
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
        SWITCH_AUTHOR_FORM(state, Boolean) {
            state.showAuthorForm = Boolean
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
        SWITCH_PAPER_BOOK_FORM(state, Boolean) {
            state.showPaperBookForm = Boolean
        },
        CREATE_AUTHOR(state, author) {
            state.authorToEdit = author
        },
        SET_AUTHOR_TO_ADD(state, author) {
            state.authorToEdit = author
        },
        CREATE_AUTHORSHIP(state, authorship) {
             state.authorshipToEdit = authorship
        },
        SET_AUTHORS(state, authors) {
            state.authors = authors
        },
        SET_ALL_BOOKS(state, books) {
            state.allBooks = books
        },
        CREATE_ABSTRACT_BOOK(state, book) {
            state.abstractBook = book
        },
    },
    actions: {
        getBooks({commit}, title = "") {
            axios.get('/bookCopy', {params: {title: title.title, libId: title.libId}})
                .then(response => {
                    var books = response.data.sort((a, b) => a.id - b.id)
                    commit('SET_BOOKS', books)
                })
        },
        createBook({commit}, book) {
            axios.post('/bookCopy', book)
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
        createAuthorship({commit}, authorship) {
            axios.post('/authorship', authorship)
                .then(response => {
                    if (response.status == '200') {
                        console.log(response.data)
                        console.log(response.status)
                        commit('CREATE_AUTHORSHIP', response.data)
                    }
                })
                .catch(error => {
                    console.log(error)
                })
        },
        createGenre({commit}, genre) {
            axios.post('/genre', genre)
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
            axios.post('/paperBook', paperBook)
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
        createAbstractBook({commit}, book) {
            axios.post('/book', book)
                .then(response => {
                    if (response.status == '200') {
                        console.log(response.data)
                        console.log(response.status)
                        commit('CREATE_ABSTRACT_BOOK', response.data)
                    }
                })
                .catch(error => {
                    console.log(error)
                })
        },
        createAuthor({commit}, author) {
            axios.post('/author', author)
                .then(response => {
                    if (response.status == '200') {
                        console.log(response.data)
                        console.log(response.status)
                        commit('CREATE_AUTHOR', response.data)
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
            commit('SET_BOOK_TO_EDIT', bookToEdit)
        },
        setAuthor({commit}, author) {
            commit('SET_AUTHOR_TO_ADD', author)
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
        switchPaperBookForm({commit}, Boolean) {
            commit('SWITCH_PAPER_BOOK_FORM', Boolean)
        },
        switchAuthorForm({commit}, Boolean) {
            commit('SWITCH_AUTHOR_FORM', Boolean)
        },
        setBookToOpen({commit}, book) {
            commit('SET_BOOK_TO_OPEN', book)
        },
        getGenres({commit}) {
            axios.get('/genre')
                .then(response => {
                    var genres = response.data.sort((a, b) => a.id - b.id)
                    commit('SET_GENRES', genres)
                }).catch(error => {
                console.log(error)
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
                    commit('SET_PAPER_BOOKS', paperBooks)
                }).catch(error => {
                console.log(error)
            })
        },
        getLibs({commit}) {
            axios.get('/libraryOffice')
                .then(response => {
                    var libs = response.data.sort((a, b) => a.id - b.id)
                    commit('SET_LIBS', libs)
                }).catch(error => {
                console.log(error)
            })
        },
        getAuthors({commit}) {
            axios.get(`/author`).then(response => {
                var authors = response.data.sort((a, b) => a.id - b.id)
                commit('SET_AUTHORS', authors)
            }).catch(error => {
                console.log(error)
            })
        },
        getAllBooks({commit}) {
            axios.get(`/books`).then(response => {
                var authors = response.data.sort((a, b) => a.id - b.id)
                commit('SET_ALL_BOOKS', authors)
            }).catch(error => {
                console.log(error)
            })
        },

    },
    getters: {
        getBook: state => state.bookToOpen
    }
})