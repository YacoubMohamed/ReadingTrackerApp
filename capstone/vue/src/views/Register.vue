<template>
  <div id="register" class="text-center">
    <div class="container-register">
      {{user}}
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <input
        v-model="user.role"
        type="radio"
        name="userRole"
        value="ROLE_ADMIN"
      />
      <label for="parent">Parent</label>
      <br />
      <input
        v-model="user.role"
        type="radio"
        name="userRole"
        value="child"
      />
      <label for="child">Child</label>
    
      <br />

       <div v-if="user.userRole === 'child'">
        <input v-model="user.ageCheck" type="checkbox" name="agecheck" />
        <label for=" agecheck"> Are you older than 13? </label>
      </div>
       <br />
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <br>
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <br>
      
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <br />
     
      <div class="account">

      <div class="cont1">
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      </div>

      <div class="cont2">
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
      </div>
      </div>
    </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
        ageCheck: false,
        userRole: "",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else if (this.user.ageCheck == false && this.user.userRole == "child") {
        this.registrationErrors = true;
        this.registrationErrorMsg =
          "You must be 13 or older to be able to have an account";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>

.account {
  
  display: flex;
  justify-content: space-evenly;
}
.container-register {
  height: 100vh;
  background-color: rgb(201, 233, 226);
  display: flex;
  flex-direction: column;
  align-items: center;
}

.form-register {
  border: 1px solid rgb(150, 145, 145);
  border-radius: 10px;
  margin-top: 3em;
  padding: 0px 20px 20px 20px;
   background-color: rgb(162, 204, 195);
  box-shadow: inset 0 0 15px rgb(128, 192, 178);

}

h1 {
  padding: .5em 1em 0em 1.5em;

}

</style>
