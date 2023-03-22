# Gestionale Ospedale Matteo Benvenuti


API di gestione di visite mediche

Ogni visita medica è caratterizzata da:
- Nominativo di riferimento
- Codice Fiscale
- Codice univoco randomico assegnato automaticamente dal sistema (NO DB)
- Codice segreto randomico
- Esito della visita (descrizione lunga)
- Data della visita

Richieste:
- CRUD delle visite mediche
- Ricerca di tutte le visite mediche afferenti ad un codice fiscale
- Ricerca di tutte le visite mediche svolte in una precisa data
- Ricerca di tutte le visite mediche svolte in un intervallo di date
- Ricerca di un referto per combinazione di codice univoco/codice segreto