Context:
We assemble vehicles for different profiles and options. A VehicleSpec captures all configuration for a single vehicle model.

Required fields: model, seats, paintColor, engine
Optional fields: sunroof, abs, autopilot, tireType, gpsTuning, vinTag, extras
Business rules:

autopilot requires an ElectricEngine
seats > 0
paintColor not blank
If tireType = "OffRoad", then abs must be true
vinTag (if present) must be exactly 17 uppercase alphanumerics