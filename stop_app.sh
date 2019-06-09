kill -9 $(cat frontend/frontend.pid)
kill -9 $(cat backend/backend.pid)
echo "Both apps killed"
