<template>
  <div class="main mx-auto">
      <h1> Manage {{$store.state.user.username}}'s Books!</h1>
    <add-book/>
    <add-reading-activity/>
  </div>
</template>

<script>
import AddBook from '../components/AddBook.vue'
import AddReadingActivity from '../components/AddReadingActivity.vue'
export default {
components: 
{AddBook, AddReadingActivity},
}
</script>

<style scoped>

</style>