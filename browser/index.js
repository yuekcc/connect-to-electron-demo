const { app, BrowserWindow } = require('electron');

!(async () => {
  app.disableHardwareAcceleration();

  app.on('browser-window-created', (_, win) => {
    win.maximize();
  });

  app.on('window-all-closed', () => {
    console.log('[APP] all window closed, quit');
    app.quit();
  });

  await app.whenReady();
  console.log('[APP] app get ready');

  const { chrome, node, electron } = process.versions;
  console.log('[APP] component versions: chromium %s, node.js %s, electron %s', chrome, node, electron);

  const win = new BrowserWindow();
  win.loadURL('about:blank');
})();
