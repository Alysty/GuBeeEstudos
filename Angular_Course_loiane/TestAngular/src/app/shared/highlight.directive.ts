import {Directive, HostBinding, HostListener, Input} from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {

  @HostListener('mouseenter') onMouseIsOver(){
    this.backgroundColor = 'black'
  }
  @HostListener('mouseleave') onMouseIsNotOver(){
    this.backgroundColor = this.defaultColor
  }

  @Input() defaultColor: string = 'white';
  @Input() highlightColor: string = 'grey';


  @HostBinding('style.backgroundColor') backgroundColor: string = 'white';
  constructor() { }

  ngOnInit(){
    this.backgroundColor = this.defaultColor;
  }

}
