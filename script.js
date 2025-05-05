document.addEventListener('DOMContentLoaded', () => {
    document.querySelectorAll('details').forEach(detail => {
      const icon = detail.querySelector('summary i');

      detail.addEventListener('toggle', () => {
        if (detail.open) {
          icon.classList.remove('bi-plus-lg');
          icon.classList.add('bi-dash-lg');
        } else {
          icon.classList.remove('bi-dash-lg');
          icon.classList.add('bi-plus-lg');
        }
      });
    });
});
