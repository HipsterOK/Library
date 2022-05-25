<template>
    <div>
        <table class="table table-striped" v-if="issuances && issuances.length">
            <thead class="table-dark">
            <tr>
                <th scope="col">Название книги</th>
                <th scope="col">Логин</th>
                <th scope="col">Статус возврата</th>
                <th scope="col">Дата выдачи</th>
                <th scope="col">Дата сдачи</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="issuance of issuances" :key="issuance">
                <td>{{ issuance.bookCopy.paperBook.title }}</td>
                <td>{{ issuance.user.login }}</td>
                <td v-if="issuance.isFinished">Книга возвращена</td>
                <td v-else>Не возвращена</td>
                <td>{{ issuance.startDate }}</td>
                <td>{{ issuance.endDate }}</td>
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
                issuances: [],
            }
        },
        created() {
            axios.get(`/issuance`).then(response => {
                this.issuances = response.data;
            })

        }
    }
</script>