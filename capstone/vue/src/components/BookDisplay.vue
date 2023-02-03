<template>
<div class="main">
  <div class="books">
      <h1> Title: {{ book.title }}</h1>
      <h2> Author: {{ book.author }}</h2>
      <p> ISBN: {{ book.isbn }}</p>
  </div>
  </div>
</template>

<script>
export default {
name: "book-display",
props: ["book"],
}
</script>

<style>
.main {
    display: flex;
}
.books {
  display: flex;
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}
</style>