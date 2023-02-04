<template>
  <div class="home">
    <div class="div-one">
      <div class="container-one">
        <img src="../assets/logo.jpg" alt="Read" />
      </div>

      <div class="container-two">
        <div class="welcome">
          <h1>Welcome, {{ $store.state.user.username }}!</h1>
          <img src="../assets/book.webp" alt="" />
        </div>
      </div>
      <br />
      <div class="container-three">
        <div class="prompt">What would you like to do?</div>

        <ul class="menu-nav">
          <li class="choice">
            <router-link v-bind:to="{ name: 'manageBooks' }">
              Your Books
            </router-link>
          </li>

          <li class="choice">
            <router-link v-bind:to="{ name: 'addBook' }">
              Manage Books
            </router-link>
          </li>

          <li class="choice">
            <router-link v-bind:to="{ name: 'manageFamily' }">
              Manage Family
            </router-link>
          </li>
        </ul>
      </div>
    </div>
    <div class="div-two">
      <div class="number-of-books">
        <p class="infographic">1000 PAGES</p>
      </div>

      <div class="graphics">
        <p class="infographic">HERE IS THE GRAPH</p>
      </div>

    </div>
   
    <div class="div-three">
       
      <div class="spouse">
        <p> Family Members </p>
        <img src="../assets/bookworm.jpg" alt="" />
      </div>
      <div class="child 1">
        <img src="../assets/baby.jpg" alt="" />
      </div>
      <div class="child 2">
        <img src="../assets/funnyboy.jpg" alt="" />
      </div>
    </div>
  </div>
</template>

<script>
//import Register from './Register.vue';
export default {
  //components: { Register },
  name: "home",
};
</script>

<style scoped>


.home {
  height: 100vh;
  background-color: rgb(175, 207, 233); 
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.div-one {
    height: 100vh;
  display: flex;
  flex-direction: column;
justify-content: space-around;

}
.div-two {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
.infographic {
  border: 1px solid black;
  border-radius: 2px;
  padding: 5em;
  background-color: rgb(212, 187, 214);
}
.div-three {
    height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}

.container-one {
  margin-top: 5%;
}

.div-three img {
   height: 8rem;
  border-radius: 50%;
}

.welcome img {
  height: 8rem;
  border-radius: 50%;
  
}

.prompt {
  font-size: 20px;
  font-weight: bold;
  width: 100%;
}

.choice,
.choice a {
  color: rgb(65, 65, 158);
  font-weight: bold;
  list-style: none;
  text-decoration: none;
}
</style>
