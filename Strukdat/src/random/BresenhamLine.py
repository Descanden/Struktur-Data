import matplotlib.pyplot as plt

def draw_line(x1, y1, x2, y2):
    dx = abs(x2 - x1)
    dy = abs(y2 - y1)
    steep = dy > dx
    
    if steep:
        x1, y1 = y1, x1
        x2, y2 = y2, x2
    
    if x1 > x2:
        x1, x2 = x2, x1
        y1, y2 = y2, y1
    
    dx = x2 - x1
    dy = abs(y2 - y1)
    
    error = dx / 2
    ystep = 1 if y1 < y2 else -1
    y = y1
    
    points = []
    for x in range(x1, x2 + 1):
        coord = (y, x) if steep else (x, y)
        points.append(coord)
        error -= dy
        if error < 0:
            y += ystep
            error += dx
            
    return points

# Koordinat titik awal garis
x1, y1 = 2, 6

# Koordinat titik akhir garis
x2, y2 = 6, 6

# Menggambar garis menggunakan algoritma Bresenham Midpoint
line_points = draw_line(x1, y1, x2, y2)

# Membuat gambar dan sumbu
fig, ax = plt.subplots()

# Menarik garis menggunakan hasil dari algoritma Bresenham Midpoint
for point in line_points:
    ax.plot(point[0], point[1], 'bo')  # Titik garis

# Menandai titik awal dan akhir garis
ax.plot(x1, y1, 'ro', label='Titik Awal')  # Titik awal
ax.plot(x2, y2, 'go', label='Titik Akhir')  # Titik akhir

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
