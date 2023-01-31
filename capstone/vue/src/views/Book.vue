<template>
  <div class="main mx-auto">
      <h1> Manage {{$store.state.user.username}}'s Books!</h1>
    <add-book/>
  </div>
</template>

<script>
import AddBook from '../components/AddBook.vue'
export default {
components: {AddBook},
}
</script>

<style scoped>

</style>