<template>
  <div class="home">
    <h1>Welcome, {{ $store.state.user.username }}!</h1>
  <div class="prompt">What would you like to do?</div>

  <ul>
    <li class="choice">
<router-link v-bind:to="{name: 'addBook'}">
  Manage Books 
</router-link>
    </li>
    <li class="choice">
<router-link v-bind:to="{name: 'setGoals'}">
  Manage Goals 
</router-link>
    </li>
  </ul>

  </div>
</template>

<script>
//import Register from './Register.vue';
export default {
  //components: { Register },
  name: "home"
};
</script>

<style scoped>

.home {
  display: grid;
  grid-template-areas: 
    "welcome welcome welcome"
    "prompt prompt prompt"
    "choice choice choice"
  ;
}

h1{
    grid-area: welcome;
}

.prompt {
  font-size: 18px;
  font-weight: bold;
  padding-left: 2em;
  padding-right: 2em;
  width: 70%;
  grid-area: prompt;
}

.choice,
.choice a {
  color: rgb(65, 65, 158);
  font-weight: bold;
  list-style: none;
  text-decoration: none;
  grid-area: choice;
}
</style>
