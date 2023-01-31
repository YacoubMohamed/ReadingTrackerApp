<template>
  <div class="main mx-auto">
      <h1> Welcome {{$store.state.user.username}}</h1>
    <add-book/>
  </div>
</template>

<script>
import AddBook from '../components/AddBook.vue'
export default {
components: {AddBook},
}
</script>

<style>

</style>