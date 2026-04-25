#!/bin/bash
# 1. DockerHub'dan en güncel imajı çek
docker pull ecembasakk/libraryplace-backend:latest

# 2. Varsa eski yapıyı durdur (Hata alsa bile durma - || true)
sudo docker compose down || true

# 3. Yeni imajla sistemi arka planda (-d) ayağa kaldır
sudo docker compose up -d