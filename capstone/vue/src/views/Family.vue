<template>
  <div class="main-mx-auto">
      <h1>Welcome {{$store.state.user.username}}</h1>
      
      <manage-family/>
      <router-link v-bind:to="{ name: 'register' }">
              Add your child
            </router-link>
  </div>
</template>

<script>
import ManageFamily from '../components/ManageFamily.vue'

export default {
components:{ ManageFamily },

}
</script>

<style>

</style>