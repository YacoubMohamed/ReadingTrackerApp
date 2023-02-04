<template>
  <div class="main mx-auto">
    <a
      id="showForm"
      href="#"
      v-if="showForm === false"
      v-on:click.prevent="showForm = true"
    >
      Add a Family
    </a>

    <form
      id="book-form"
      v-on:submit.prevent="addNewFamily"
      v-if="showForm === true"
    >
      <div class="form-element">
        <label for="fm">Family Name: </label>
        <input id="fm" type="text" v-model="family.family_name" />
      </div>
      <div id="button-row">
        <input id="buttons" type="submit" value="Save" />
        <input
          id="buttons"
          type="button"
          value="Cancel"
          v-on:click="resetForm"
        />
      </div>
    </form>
  </div>
</template>

<script>
import familyReadingService from "../services/FamilyReadingService";
export default {
  name: "manage-family",
  data() {
    return {
      member: {
        username: "",
        userRole: "",
      },
      user: {
        username: "",
      },
      showForm: false,
      family: {
        family_name: "",
      },
      userList: [],
      filterList: [],
      searchWord: "",
    };
  },
  created() {
    familyReadingService.displayFamily().then((response) => {
      this.family = response.data;
      console.log("this is where my family is");
    });
  },
  methods: {
    resetForm() {
      this.showForm = false;
      this.family = {
        family_name: "",
      };
    },
    addNewFamily() {
      familyReadingService.addFamily(this.family).then((response) => {
        if (response.status == 200) {
          alert("Success");
          this.family = response.data;
          this.$store.commit("ADD_FAMILY", this.family);
          this.resetForm();
          //this is where you can call another API call to retrieve brand new list of books
          //route back to home page
        } else {
          alert("unsuccessful");
        }
      });
    },
    search() {
      return (this.filterList = this.userList.filter((user) => {
        return user.username.includes(this.searchWord);
      }));
    },
  },
};
</script>

<style scoped>
.form-element {
    padding-left: 4em;
}
#showForm {
    text-decoration: none;
    padding-left: 2em;
}
#buttons {
    margin-right: 10px;
}
#button-row {
    padding-left: 8em;
}
</style>