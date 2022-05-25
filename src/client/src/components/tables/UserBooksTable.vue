<template>
    <div>
        <table class="table table-striped" v-if="userBooks && userBooks.length">
            <thead class="table-dark">
            <tr>
                <th scope="col">Название книги</th>
                <th scope="col">Дата окончания аренды</th>
                <th scope="col">Статус возврата</th>
                <th scope="col">Действия</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="userBook of userBooks" :key="userBook">
                <td>{{ userBook.bookCopy.paperBook.title }}</td>
                <td>{{ userBook.endDate }}</td>
                <td v-if="userBook.isFinished">✓</td>
                <td v-else>X</td>
                <td>
                    <button class="btn btn-secondary" style="margin-right:10px;" v-if="!userBook.isFinished"
                            @click="extendUserBook(userBook)">Продлить на месяц
                    </button>
                    <a v-else>Продлить невозможно</a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
        data() {
            return {
                userBooks: [],
            }
        },
        methods: {
            extendUserBook: function (issuance) {
                var dateIssuance = new Date(issuance.endDate);
                var dateNow = new Date();
                if ((dateNow.getMonth() - dateIssuance.getMonth()) > 0 && (dateNow.getMonth() - dateIssuance.getMonth()) < 4 && (dateNow.getFullYear() - dateIssuance.getFullYear()) === 0) {
                    axios.put(`/issuance/extend/${issuance.id}`)
                        .then(r => console.log(r.statusText + 'данные сохранены'))
                    location.reload()
                } else {
                    alert("Нельзя продлить аренду больше чем на 3 месяца")
                }
            }
        },
        created() {
            //todo брать пользователь из текущей сессии
            var currentUser = axios.get(`/user`, {params: {id: 1}})
            axios.get(`/issuance`, {params: {user: currentUser}}).then(response => {
                this.userBooks = response.data
            })
        }
    }
</script>