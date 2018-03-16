insert into auto_reply select * from(
  select 1, 'pab', 'Pussy Aaaasss Beootch' union
  select 2, 'pab', 'HAHAHAH Stomme pussy. Ik wist wel da ge ni durfde. Ga nu maar naar huis wenen. n00b' union
  select 3, 'pab', 'Doe maar in uw broek, *weenbaby* :baby_symbol: :droplet:' union
  select 4, 'mondje', 'houd uwen bek eens' union
  select 5, 'mondje', 'shut the *FUCK* up' union
  select 6, 'mondje', 'mondje, *FUCKFACE*' union
  select 7, 'mondje', 'zijt nu eens stil, *kletswijf* :angry:' union
  select 8, 'mondje', 'hou die vuile *KAKBEK* nu eens fucking dicht, *KWEBBELAAR* ' union
  select 9, 'fuck', 'f woord' union
  select 10, 'fuck', 'nou nou nou' union
  select 11, 'fuck', 'sow' union
  select 12, 'godverdomme', 'g woord' union
  select 13, 'godverdomme', 'nou nou nou' union
  select 14, 'godverdomme', 'sow' union
  select 15, 'godverdomme', 'Allah dammit' union
  select 16, 'hoer', 'h woord' union
  select 17, 'kut', 'k woord' union
  select 18, 'kalm', ':angry:  :angry:  :angry:  IK BEN *KALM*  :angry:  :angry:  :angry:' union
  select 19, 'zalm', ':fish: :fish: :fish: IK BEN *ZALM* :fish: :fish: :fish:' union
  select 20, 'sorry', 'sgoed jonge' union
  select 21, 'mandje', 'Mand in, en kop houden!' union
  select 22, 'rustig', ':angry:  :angry:  :angry:  IK BEN *RUSTIG*  :angry:  :angry:  :angry:' union
  select 23, 'ok', 'ok' union
  select 24, '8ste', 'ok' union
  select 25, 'bart', 'ok'
) where not exists(select * from auto_reply);