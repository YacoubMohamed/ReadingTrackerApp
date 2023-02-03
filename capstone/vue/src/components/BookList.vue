<template>
  
  <div class="main mx-auto">
<h2>Your books are: {{books}}</h2>
  </div>
</template>

<script>
import familyReadingService from '../services/FamilyReadingService'
export default {
name: 'book-list',
data(){
    return{
        books: [],
    };
},
created(){
    familyReadingService.getBooks().then(response =>{
        this.books = response.data;
        console.log(this.books);
    })
}

}
</script>

<style>

</style>