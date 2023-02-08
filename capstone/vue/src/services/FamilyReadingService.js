import axios from 'axios';

export default {

  addBook(book) {
    return axios.post('/addBook', book)
  },
  addReadingActivity(activity) {
    return axios.post('/addActivity', activity)
  },
  getBooks() {
    return axios.get('/books/list')
  },
  displayFamily() {
    return axios.get('/family/list/${familyId}')
  },
  addFamily(family) {
    return axios.post('/addFamily', family)
  },

  displayUsers() {
    return axios.get('/displayUsers')
  },
  addUserToFamily(familyId, user) {
    console.log('ADD USER TO FAMILY');

    return axios.put(`/family/${familyId}/${user.id}`, user)
  },
  getBookByUser() {
    return axios.get(`/books/userList`)
  }



}
