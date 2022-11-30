<template>
  <div>
    <nav class="navbar navbar-expand-lg">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Artisian Manager</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div id="navbarSupportedContent" class="collapse navbar-collapse">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Cadastro
              </a>
              <ul class="dropdown-menu">
                <li>
                  <nuxt-link class="dropdown-item" to="/units"
                    >Unidade</nuxt-link
                  >
                </li>
                <li>
                  <nuxt-link class="dropdown-item" to="/raw-materials"
                    >Matéria Prima</nuxt-link
                  >
                </li>
                <li>
                  <nuxt-link class="dropdown-item" to="/recipes"
                    >Material Acabado</nuxt-link
                  >
                </li>
              </ul>
            </li>
            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Estoque
              </a>
              <ul class="dropdown-menu">
                <li>
                  <nuxt-link class="dropdown-item" to="#"
                    >Matéria Prima</nuxt-link
                  >
                </li>
                <li>
                  <nuxt-link class="dropdown-item" to="#"
                    >Material Acabado</nuxt-link
                  >
                </li>
              </ul>
            </li>
            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Relatórios
              </a>
              <ul class="dropdown-menu">
                <li>
                  <nuxt-link class="dropdown-item" to="/units"
                    >Unidade</nuxt-link
                  >
                </li>
                <li>
                  <nuxt-link class="dropdown-item" to="/raw-materials"
                    >Matéria Prima</nuxt-link
                  >
                </li>
                <li>
                  <nuxt-link class="dropdown-item" to="/recipes"
                    >Material Acabado</nuxt-link
                  >
                </li>
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Sobre</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'NavComponent',
}
</script>

<style>
li {
  padding: 0 20px;
}
.navbar {
  background-color: transparent;
}
.navbar-brand {
  color: var(--secondary-color-100);
  font-size: 1.5rem;
}

.dropdown > a,
.nav-item > a {
  color: var(--white-color-100);
}

.dropdown-menu {
  background-color: var(--background-color);
}

.dropdown-item {
  color: var(--white-color-80);
}

.dropdown-item:hover {
  background-color: var(--background-color);
  color: var(--white-color-100);
}
</style>
