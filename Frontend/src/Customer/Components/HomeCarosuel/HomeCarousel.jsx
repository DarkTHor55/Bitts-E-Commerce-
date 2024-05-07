import React from 'react';
import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import { HomeCarouselData } from './HomeCarouselData';


function HomeCarousel() {
    
    const items=HomeCarouselData.map((item)=>(
        <img className='cursor-pointer -z-10'  src={item.image} role='presentation' alt='img'/>
    ))
    return (
        <AliceCarousel
            items={items}
            disableButtonsControls
            autoPlay
            autoPlayInterval={4000}
            infinite 
        />
    );
}

export default HomeCarousel;
