<template>
    <div class="form-bg">
        <form @submit.prevent class="form">
            <input v-model="book.title" type="text" placeholder="Название книги"/>
            <input v-model="book.description" type="text" placeholder="Описание книги"/>
            <input v-model="book.quantity" type="number" placeholder="Количество"/>
            <!--      <input v-model="book.type" type="text" placeholder="Тип книги" />-->
            <select v-model="book.type">
                <option value="AUDIO_BOOK">AUDIO_BOOK</option>
                <option value="PHYSICAL_BOOK">PHYSICAL_BOOK</option>
                <option value="VIDEO_BOOK">VIDEO_BOOK</option>
            </select>
            <!--      <input v-model=" book.genre.name" type="text" placeholder="Жанр" />-->
            <select v-model="book.genre">
                <option v-for="genre in genres" :value="genre" :key="genre">
                    {{ genre.name }}
                </option>
            </select>
            <input v-model=" book.addDate" type="text" placeholder="Дата добавления:"/>
            <!--      <input v-model="  book.libId.name " type="text" placeholder="Библиотека:" />-->
            <select v-model="book.libId">
                <option v-for="lib in libs" :value="lib" :key="lib"> {{ lib.name }} </option>
            </select>
            <input v-model="  book.src " type="text" placeholder="Ссылка:"/>

            <button @click="saveBook"> Сохранить</button>
            <button @click="closeForm"> X</button>
        </form>
    </div>
</template>

<script>
    export default {
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
        height: 350px;
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