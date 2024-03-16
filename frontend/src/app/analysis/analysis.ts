enum AnalysisManufacture {
  GOOGLE = 'GOOGLE',
  APPLE = 'APPLE',
  SAMSUNG = 'SAMSUNG',
  HUAWEI = 'HUAWEI',
}

enum AnalysisLookAndFeel {
  VERY_GOOD = 'VERY_GOOD',
  GOOD = 'GOOD',
  VERY_BAD = 'VERY_BAD',
  UNACCEPTABLE = 'UNACCEPTABLE',
}

enum AnalysisOs {
  ANDROID = 'ANDROID',
  IOS = 'IOS',
  HARMONY_OS = 'HARMONY_OS',
}

export interface Analysis {
  phoneName: string;
  price: number;
  manufacture: AnalysisManufacture;
  lookAndFeel: AnalysisLookAndFeel;
  ram: number;
  os: AnalysisOs;
  osVersion: number;
  storage: number;
  cam: number;
}
