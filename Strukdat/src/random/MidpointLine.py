import matplotlib.pyplot as plt

# Koordinat titik awal garis
x1, y1 = 2, 6

# Koordinat titik akhir garis
x2, y2 = 6, 6

# Menghitung titik tengah
midpoint_x = (x1 + x2) / 2
midpoint_y = (y1 + y2) / 2

# Membuat gambar dan sumbu
fig, ax = plt.subplots()

# Menarik garis lurus dari titik awal ke titik akhir
ax.plot([x1, x2], [y1, y2], color='blue', label='Garis')

# Menandai titik awal, akhir, dan tengah garis
ax.plot(x1, y1, 'o', color='red', label='Titik Awal')  # Titik awal
ax.plot(x2, y2, 'o', color='green', label='Titik Akhir')  # Titik akhir
ax.plot(midpoint_x, midpoint_y, 'o', color='purple', label='Titik Tengah')  # Titik tengah

# Menambahkan label sumbu
ax.set_xlabel('X')
ax.set_ylabel('Y')

# Menambahkan judul
ax.set_title('Garis BD')

# Menampilkan legenda
plt.legend()

# Menampilkan gambar
plt.grid(True)
plt.show()
