<template>
  <div class="home">
    <h1>Welcome users!</h1>
  <div class="prompt">What would you like to do?</div>

  <ul>
    <li class="choice">
<router-link v-bind:to="{name: 'addBook'}">
  Add Your Book 
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
.prompt {
  font-size: 18px;
  font-weight: bold;

  border: 2px solid black;
  padding: 10px;
  width: 70%;
}

.choice,
.choice a {
  color: blue;
  font-weight: bold;
}
</style>
