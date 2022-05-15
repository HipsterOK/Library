<template>
    <div>
        <table class="table table-striped" v-if="debtors && debtors.length">
            <thead class="table-dark">
            <tr>
                <th scope="col">ФИО пользователя</th>
                <th scope="col">Номер телефона</th>
                <th scope="col">Название книги</th>
                <th scope="col">Автор</th>
                <th scope="col">Дата сдачи</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="debtor of debtors" :key="debtor">
                <td>{{ debtor.userFullName }}</td>
                <td>{{ debtor.userPhone }}</td>
                <td>{{ debtor.bookTitle }}</td>
                <td>{{ debtor.bookAuthorFullName }}</td>
                <td>{{ debtor.deliveryDate }}</td>
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
                debtors: [],
            }
        },
        created() {
            axios.get(`http://localhost:8081/issuance/debtors`).then(response => {
                this.debtors = response.data
            })
        }
    }
</script>