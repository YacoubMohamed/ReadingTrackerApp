<template>
  <div class="home">
    <div class="main">
      <h2>Grace is happy</h2>
    </div>
    <div class="welcome">
    <h1>Welcome, {{ $store.state.user.username }}!</h1>
    </div>
  <div class="prompt">What would you like to do?</div>

  <ul class="menu-nav">
    
    <div id = "booklist">
      <li class="choice">
      <router-link v-bind:to="{ name: 'manageBooks' }">
          Your Books
        </router-link>
        </li>
    </div>
    <li class="choice">
<router-link v-bind:to="{name: 'addBook'}">
  Manage Books 
</router-link>
    </li>
    <li class="choice">
<router-link v-bind:to="{name: 'manageFamily'}">
  Manage Family
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
    "welcome main main"
    "prompt main main"
    "menu-nav main main"
  ;
}
/* #booklist {
  grid-area: booklist;
} */


.menu-nav {
  grid-area: menu-nav;
}
.main {
  grid-area: main;
}
.welcome {
  padding-left: 2em;
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
