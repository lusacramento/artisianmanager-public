export default function ({ $axios, redirect }) {
  $axios.onError((error) => {
    const status = `erro: ${error.response.status}`
    const message = `mensagem: ${error.response.data.title}`

    const info = 'status: ' + status + '\n' + message
    alert(info)
  })
}
