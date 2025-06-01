//Abre Modal
const openModal = document.querySelectorAll('.open-modal');

openModal.forEach(h2 => {
  h2.addEventListener('click', () => {
    const modalId = h2.getAttribute('data-modal');
    const modal = document.getElementById(modalId);

    modal.showModal();
  });
});


//Fecha Modal
const closeModal = document.querySelectorAll('.close-modal');

closeModal.forEach(button => {
  button.addEventListener('click', () => {
    const modalId = button.getAttribute('data-modal');
    const modal = document.getElementById(modalId);

    modal.close();
  });
});

//Saudacao
function atualizarSaudacao() {
  const agora = new Date();
  const hora = agora.getHours(); // 0–23
  let texto = '';

  if (hora >= 5 && hora < 12) {
    texto = 'Bom dia!';
  } else if (hora >= 12 && hora < 18) {
    texto = 'Boa tarde!';
  } else {
    texto = 'Boa noite!';
  }

  // Insere a saudação no elemento
  const el = document.getElementById('saudacao');
  el.textContent = texto;
}

// Executa ao carregar a página
window.addEventListener('DOMContentLoaded', atualizarSaudacao);
