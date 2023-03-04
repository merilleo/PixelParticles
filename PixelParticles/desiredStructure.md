# This is the desired Structure to define and initialize a Particle System

``` Java
ParticleSystem ps = new ParticleSystem({
    width: 1000,
    height: 500  
    forceFields: [
        {
            type: linear,
            columns: 10,
            rows: 10,
            forceType: {
                type: perlin,
                size: 1.0F,
                strength: 10F
            }
        },
        {
            type: linear,
            columns: 10,
            rows: 10,
            forceType: {
                type: random
                strength: 10F
            }
        },
        {
            type: image,
            columns: 10,
            rows: 10,
            forceType: {
                type: linear
                strength: 10F
            }
        }
    ],
    forces: [
        {
          type: linear,
          strength: 2.0F,
          directionX: 1F,
          directionY 0.5F,
        },
        {
            type: random,
            strength: 5.0F
        }
    ],
    drawing: [
        {
            type: circle,
            size: 3
            color: {
                type: image,
                update: 0,
                image: {
                    filePath: "data/uv_checker.png"
                }
            }
        },
        {
            type: line,
            size: 1,
            color: {
                type: constant,
                values: {
                    r: 255,
                    g: 0,
                    b: 255,
                    a: 1.0F
                }
            }
        },
        {
            type: line,
            size: 1,
            color: {
                type: velocity,
                values: {
                    r: 255,
                    g: 0,
                    b: 255,
                    a: 1.0F
                }
            }
        },
    ],
    
});

```