<template>
  <div id="app" class="app container-fluid">
    <div id="nav">
      <Nav :base-url="baseUrl" />
    </div>
    <main id="main" class="router-view">
      <Nuxt />
    </main>
    <footer id="footer" class="footer fixed-bottom">
      <Footer />
    </footer>
  </div>
</template>

<script>
import Nav from '@/components/navAndFooter/Nav'
import Footer from '@/components/navAndFooter/Footer'
export default {
  name: 'DefaultLayout',
  components: { Footer, Nav },
  data() {
    return {
      baseUrl: 'http://localhost:3000/',
    }
  },
}
</script>
<style>
#app {
  display: grid;
  height: 99vh !important;
  grid-template-rows: 20vh 70vh 11vh;

  grid-template-areas:
    'nav'
    'main'
    'foot';
}
#nav {
  grid-area: nav;
}
#main {
  grid-area: main;
}
#footer {
  grid-area: foot;
}
</style>
