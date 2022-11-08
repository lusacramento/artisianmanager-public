export default function ({ $axios, redirect }) {
  $axios.onError((error) => {
    const status = `erro: ${error.response.status}`
    const message = `mensagem: ${error.response.data.title}`

    if (error.response.status === 400) {
      if (error.response.data.title.includes('Já existe')) {
        alert(status, '\n', message)
      }
    }

    if (error.response.status === 404) {
      if (error.response.data.title.includes('não encontrada')) {
        alert(`${status} \n${message}`)
      }
    }
  })
}
