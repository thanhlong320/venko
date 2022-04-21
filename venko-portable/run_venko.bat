@echo off
netstat -nao | findstr 4200 | findstr LISTENING >nul 2>nul && (
  echo Another application is using port 4200. Please close it before running venko portable?
  pause
) || (
    netstat -nao | findstr 8080 | findstr LISTENING >nul 2>nul && (
    echo Another application is using port 8080. Please close it before running venko portable?
    pause
  )||(
    docker-compose down
    docker-compose pull 
    docker-compose up -d
    echo Venko is currently running on http://localhost:4200, it may take a bit longer to fully startup.
    pause
    )
  )
