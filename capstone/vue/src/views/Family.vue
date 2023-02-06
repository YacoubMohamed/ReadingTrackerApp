<template>
  <div class="main-mx-auto">
      <h1>Welcome {{$store.state.user.username}}</h1>
      
      
      <router-link v-bind:to="{ name: 'register' }">
              Add your child
            </router-link>
            <manage-family/>
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