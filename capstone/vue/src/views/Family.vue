<template>
  <div class="main-mx-auto">
      <h1>Welcome {{$store.state.user.username}}</h1>
      
      <h1 class="route">
      <router-link v-bind:to="{ name: 'register' }">
              Add your child
            </router-link>
            <manage-family/>
            </h1>
  </div>
</template>

<script>
import ManageFamily from '../components/ManageFamily.vue'

export default {
components:{ ManageFamily },

}
</script>

<style>
.main-mx-auto{
  background-color: blanchedalmond;
}

.route{
  text-decoration: none;
}
</style>