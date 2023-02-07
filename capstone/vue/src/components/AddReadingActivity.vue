<template>
  <div class="main mx-auto">
    <a
      id="showForm1"
      href="#"
      v-if="showForm1 === false"
      v-on:click.prevent="showForm1 = true"
    >
      Add Reading Activity
    </a>

    <form
      id="reading-form"
      v-on:submit.prevent="addNewReadingActivity"
      v-if="showForm1 === true"
    >
      <div class="form-element">
        <label for="title">
Title: </label>
        <input id="title" type="text" v-model="activity.title" />
      </div>
      <div class="form-element">
        <label for="time_read">Time Read: </label>
        <input id="time_read" type="text" v-model="activity.time_read" />
      </div>
      <div class="form-element">
        <label for="book-format">Book Format: </label>
        <input id="book_format" type="text" v-model="activity.book_format" />
      </div>
      <div class="form-element">
        <label for="notes">Notes: </label>
        <input id="notes" type="text" v-model="activity.notes" />
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
import familyService from "../services/FamilyReadingService";
export default {
  name: "add-reading",
  data() {
    return {
      showForm1: false,
      activity: {
        title: "",
        time_read: "",
        book_format: "",
        notes: "",
      },
    };
  },
  created() {},
  methods: {
    resetForm() {
      this.showForm1 = false;
      this.activity = {
        title: "",
        time_read: "",
        book_format: "",
        notes: "",
      };
    },
    addNewReadingActivity() {
      familyService.addReadingActivity(this.activity).then((response) => {
        if (response.status == 200) {
          alert("Success");
          this.activity = response.data;
          this.$store.commit("ADD_ACTIVITY", this.activity);
          this.resetForm();
          //this is where you can call another API call to retrieve brand new list of books
          //route back to home page
        } else {
          alert("unsuccessful");
        }
      });
    },
  },
};
</script>

<style scoped>
.form-element {
  padding-left: 4em;
}
#showForm1 {
  text-decoration: none;
  padding-left: 2em;
}
#buttons {
  margin-right: 10px;
}
#button-row {
  padding-left: 8em;
}
#title,
#author,
#ISBN {
  margin-left: 20px;
}
</style>