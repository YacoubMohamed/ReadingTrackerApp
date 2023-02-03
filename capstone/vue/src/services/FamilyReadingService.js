import axios from 'axios';

export default {

  addBook(book) {
    return axios.post('/book', book)
  },
  getBooks() {
    return axios.get('/books')
  },
  displayFamily() {
    return axios.get('/family')
  }

}
